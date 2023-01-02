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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.response.DeleteResponse;
import com.example.response.TutorialResponse;
import com.example.response.TutorialsResponse;

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
	public TutorialsResponse saveTutorial(Tutorial tutorial) {
		try {

			tutorialRepository.save(tutorial);

			TutorialsResponse response = saveResponseForTutorials(tutorials);
			return response;

			// redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved
			// successfully!");
		} catch (Exception e) {
			// redirectAttributes.addAttribute("message", e.getMessage());
		}

		return null;
	}

	private String saveResponseForTutorials(RedirectAttributes redirectAttributes) {
//		TutorialsResponse tutorialsResponse = new TutorialsResponse();
//
//		List<TutorialResponse> listOfTutorials = new ArrayList<>();
//		listOfTutorials.add(tutorialResponse);
		redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved successfully!");

	}

	@GetMapping("/tutorials/new")
	public TutorialsResponse addTutorial(@Param("keyword") String keyword) {
		try {
			List<Tutorial> tutorials = new ArrayList<>();

			if (keyword == null) {
				tutorialRepository.findAll().forEach(tutorials::add);
			} else {
				tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
			}

			TutorialsResponse response = createResponseForTutorials(tutorials);
			return response;
			
			Tutorial tutorial = new Tutorial();
			tutorial.setPublished(true);
		} catch (Exception e) {
			//
		}
		return null;
		
		

	}

	private TutorialsResponse addResponseForTutorials(List<Tutorial> tutorials) {
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
	public String saveTutorial(Tutorial tutorial, RedirectAttributes redirectAttributes) {
		try {
			tutorialRepository.save(tutorial);

			redirectAttributes.addFlashAttribute("message", "The Tutorial has been saved successfully!");
		} catch (Exception e) {
			redirectAttributes.addAttribute("message", e.getMessage());
		}

		return "redirect:/tutorials";
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

	@GetMapping("/tutorials/delete/{id}")
	public String deleteTutorial(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			tutorialRepository.deleteById(id);

			redirectAttributes.addFlashAttribute("message",
					"The Tutorial with id=" + id + " has been deleted successfully!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/tutorials";

	}
	private DeleteResponse deleteResponseForTutorials(@PathVariable("id") Integer id, List<Tutorial> tutorials) {
		TutorialsResponse tutorialsResponse = new TutorialsResponse();

		List<TutorialResponse> listOfTutorials = new ArrayList<>();

		if (!CollectionUtils.isEmpty(tutorials)) {
			tutorials.stream().forEach(tutorial -> {
				TutorialResponse tutorialResponse = new TutorialResponse();
				
				tutorialResponse.deleteById(id);
				DeleteResponse deleteResponse = new DeleteResponse(id);
				return deleteResponse;
			});
		}

	@GetMapping("/tutorials/{id}/published/{status}")
	public String updateTutorialPublishedStatus(@PathVariable("id") Integer id,
			@PathVariable("status") boolean published, Model model, RedirectAttributes redirectAttributes) {
		try {
			tutorialRepository.updatePublishedStatus(id, published);

			String status = published ? "published" : "disabled";
			String message = "The Tutorial id=" + id + " has been " + status;

			redirectAttributes.addFlashAttribute("message", message);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}

		return "redirect:/tutorials";
	}

}
