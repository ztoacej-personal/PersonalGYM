package www.dream.com.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.dream.com.party.model.PartyVO;
import www.dream.com.party.service.PartyService;

@RestController
@RequestMapping("/party/*")
public class PartyController {
	@Autowired
	private PartyService partyService;

	@RequestMapping("listParty")
	public void list(@RequestParam("type") String partyType, Model model) {
		model.addAttribute("listParty", partyService.selectAllParty(partyType));
	}

	@GetMapping("openRegisterParty")
	public ModelAndView registerPost() {
		ModelAndView mav = new ModelAndView("/party/registerParty");
		// mav.getModel().put("listContactPointType",
		// partyService.listContactPointType());
		return mav;
	}

	@PostMapping("registerParty")
	public ModelAndView registerParty(PartyVO newbie, RedirectAttributes rttr) {
		ModelAndView mav = new ModelAndView("redirect:/customLogin");
		partyService.registerParty(newbie);

		rttr.addAttribute("id", newbie.getId());
		return mav;
	}

	@GetMapping(value = "chkIdDup/{newId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> chkIdDup(@PathVariable("newId") String newId) {
		return new ResponseEntity<>(partyService.chkIdDup(newId), HttpStatus.OK);
	}

	@GetMapping(value = "chkNickDup/{newNick}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> chkNickDup(@PathVariable("newNick") String newNick) {
		return new ResponseEntity<>(partyService.chkNickDup(newNick), HttpStatus.OK);
	}

}
