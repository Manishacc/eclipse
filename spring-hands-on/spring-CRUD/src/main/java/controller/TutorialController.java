package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.response.DeleteResponse;
import com.example.response.DeleteTutorialRequest;
import com.example.response.DeleteTutorialResponse;
import com.example.response.SaveTutorialRequest;
import com.example.response.SaveTutorialResponse;
import com.example.response.TutorialResponse;
import com.example.response.TutorialsResponse;
import com.example.response.UpdateTutorialResponse;

import entity.Tutorial;
import repository.TutorialRepository;

@Controller
public class TutorialController {

	@Autowired
	private TutorialRepository tutorialRepository;

//	@GetMapping("/tutorials")
//	public String getAll(Model model, @Param("keyword") String keyword) {
//		try {
//			List<Tutorial> tutorials = new ArrayList<Tutorial>();
//
//			if (keyword == null) {
//				tutorialRepository.findAll().forEach(tutorials::add);
//			} else {
//				tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
//				model.addAttribute("keyword", keyword);
//			}
//
//			model.addAttribute("tutorials", tutorials);
//		} catch (Exception e) {
//			model.addAttribute("message", e.getMessage());
//		}
//
//		return "tutorials";
//	}

	@GetMapping("/tutorials")
	public TutorialsResponse getAll(@Param("keyword") String keyword) {
		try {
			List<Tutorial> tutorials = new ArrayList<>();

			if (keyword == null) {
				tutorialRepository.findAll().forEach(tutorials::add);
			} else {
				tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
			}

			TutorialsResponse response = createResponseForTutorials(tutorials);
			return response;
		} catch (Exception e) {
			//
		}
		return null;

	}

	// Input : list of tutorials from DB

	// transformed from Tutorial to TutorialResponse
	// collect tutorials in a list
	// add the list of tutorial response to final response

	// Output : list of tutorials to display
	private TutorialsResponse createResponseForTutorials(List<Tutorial> tutorials) {
		TutorialsResponse tutorialsResponse = new TutorialsResponse();

		List<TutorialResponse> listOfTutorials = new ArrayList<>();

		if (!CollectionUtils.isEmpty(tutorials)) {
			tutorials.stream().forEach(tutorial -> {
				// transformed from Tutorial to TutorialResponse
				TutorialResponse tutorialResponse = new TutorialResponse();
				tutorialResponse.setDescription(tutorial.getDescription());
				tutorialResponse.setId(tutorial.getId());
				tutorialResponse.setTitle(tutorial.getTitle());

				// collect tutorials in a list
				listOfTutorials.add(tutorialResponse);
			});
		}

		// add the list of tutorial response to final response
		tutorialsResponse.setTutorials(listOfTutorials);

		// Output : list of tutorials to display
		return tutorialsResponse;
	}

	@PostMapping("/tutorials/save")
	// take saveTutorialRequest in method parameter
	@ResponseBody
	public SaveTutorialResponse saveTutorial(@RequestBody SaveTutorialRequest saveTutorialRequest) {
		SaveTutorialResponse response;
		try {
			// map the fields from saveTutorialRequest to object of type Tutorial(private
			// method)
			Tutorial tutorial = saveTutorialDetails(saveTutorialRequest);

			tutorialRepository.save(tutorial);
			// create TutorialResponse on the basis of the status of save
			response = getTutorialResponse(true);
		} catch (Exception e) {
			response = getTutorialResponse(false);
		}
		return response;
	}

	private SaveTutorialResponse getTutorialResponse(boolean success) {
		SaveTutorialResponse tutorialResponse = new SaveTutorialResponse();
		if (success) {
			tutorialResponse.setMessage("Tutorial saved successfully!");
		} else {
			tutorialResponse.setMessage("Tutorial could not be saved successfully!");
		}
		return tutorialResponse;

	}

	private Tutorial saveTutorialDetails(SaveTutorialRequest saveTutorial) {
		Tutorial tutorial = new Tutorial();
		tutorial.setId(saveTutorial.getId());
		tutorial.setTitle(saveTutorial.getTitle());
		tutorial.setPublished(false);
		tutorial.setLevel(saveTutorial.getLevel());
		tutorial.setDescription(saveTutorial.getDescription());

		return tutorial;
	}

	@GetMapping("/tutorials/{id}")
	public String editTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Tutorial tutorial = tutorialRepository.findById(id).get();

			model.addAttribute("tutorial", tutorial);
			model.addAttribute("pageTitle", "Edit Tutorial (ID: " + id + ")");

			return "tutorial_form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());

			return "redirect:/tutorials";
		}
	}

//	@GetMapping("/tutorials/delete/{id}")
//	public String deleteTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
//		try {
//			// get id from request
//			// repository.deletebyid
//			// prepare response on basis of deletion operation
//			tutorialRepository.deleteById(id);
//
//			redirectAttributes.addFlashAttribute("message",
//					"The Tutorial with id=" + id + " has been deleted successfully!");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", e.getMessage());
//		}
//
//		return "redirect:/tutorials";
//
//	}

	@GetMapping("/tutorials/delete/{id}")
	@ResponseBody
	public DeleteTutorialResponse deleteTutorial(@RequestBody Integer id) {
		DeleteTutorialResponse response;
		try {
			// get id from request
			// repository.deletebyid
			// prepare response on basis of deletion operation

			tutorialRepository.deleteById(id);
			response = getDeleteResponse(true);
		} catch (Exception e) {
			response = getDeleteResponse(false);
		}
		return response;

	}

	private DeleteTutorialResponse getDeleteResponse(boolean success) {
		DeleteTutorialResponse tutorialResponse = new DeleteTutorialResponse();
		if (success) {
			tutorialResponse.setMessage("Tutorial has been deleted successfully!");
		} else {
			tutorialResponse.setMessage("Tutorial was not deleted!");
		}
		return tutorialResponse;
	}

	@GetMapping("/tutorials/{id}/published/{status}")
	@ResponseBody
	public UpdateTutorialResponse updateTutorialPublishedStatus(@RequestBody Integer id,
			@RequestBody boolean published) {
		UpdateTutorialResponse response;
		try {
			// get id and published values from request
			// repository.updatepublish method
			// create response on the bais of update operation

			Tutorial tutorial = updateTutorialDetails(id, published);
			tutorialRepository.updatePublishedStatus(id, published);

			response = getUpdateResponse(true);
		} catch (Exception e) {
			response = getUpdateResponse(true);

		}

		return response;
	}

	private UpdateTutorialResponse getUpdateResponse(boolean status) {
		UpdateTutorialResponse updateResponse = new UpdateTutorialResponse();
		if (status)
			updateResponse.setMessage("Tutorial updated successfully!");
		else
			updateResponse.setMessage("Tutorial update was unsuccessful!");

		return updateResponse;
	}

	private Tutorial updateTutorialDetails(Integer id, boolean published) {
		Tutorial tutorial = new Tutorial();
		tutorial.setId(id);
		tutorial.setPublished(published);
		return tutorial;
	}

//	@GetMapping("/tutorials/{id}/published/{status}")
//	@ResponseBody
//	public String updateTutorialPublishedStatus(@RequestBody Integer id,@RequestBody boolean published) {
//		try {
//			// get id and published values from request
//			// repository.updatepublish method
//			// create response on the bais of update operation
//			tutorialRepository.updatePublishedStatus(id, published);
//			
//
//			String status = published ? "published" : "disabled";
//			String message = "The Tutorial id=" + id + " has been " + status;
//
//			redirectAttributes.addFlashAttribute("message", message);
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("message", e.getMessage());
//		}
//
//		return "redirect:/tutorials";
//	}

}
