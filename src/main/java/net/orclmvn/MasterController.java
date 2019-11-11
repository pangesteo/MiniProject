package net.orclmvn;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import net.orclmvn.Member;

import net.orclmvn.Member;
import net.orclmvn.Member;


@Controller
public class MasterController {
	
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard";
	}
	
	
	@RequestMapping("/member")
	public String membermain(Model model) {
		List<Member> listMembers = memberService.listAll();
		model.addAttribute("listMembers", listMembers);
		return "member";
	}
	
	@RequestMapping(value = "/member/delete/{memberid}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable(name = "memberid") int memberid) {
		memberService.delete(memberid);
		return "redirect:/member";
		
	}
	
	@RequestMapping(value = "/member/add", method = RequestMethod.GET)
	public String memberadd(ModelMap model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "memberadded";
	}
	
	@RequestMapping(value = "/member/save", method = RequestMethod.POST)
	public String SaveProduct(@Valid Member member, BindingResult result, 
			ModelMap model, RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "memberadded";
		}
		memberService.save(member);
		return "memberadd";
	}
			
	
	@RequestMapping(value = "/member/update/update", method = RequestMethod.POST)
	public String UpdateMember(@Valid Member member, BindingResult result, 
			ModelMap model, RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "memberupdateform";
		}
		memberService.save(member);
		return "redirect:/member";
	}
			
		
		@RequestMapping(value = "/update/{memberid}", method = RequestMethod.GET)
	    public String showEditMemberPage(@PathVariable(name = "memberid") int memberid, Model model) {
			Member member = memberService.get(memberid);
			model.addAttribute("member", member);
	        return "memberupdateform";
		}
		
		///////////////////////////////////////
		@Autowired
		private AssetService assetService;
		
		@RequestMapping("/asset")
		public String assetmain(Model model) {
			List<Asset> listAssets = assetService.listAll();
			model.addAttribute("listAssets", listAssets);
			return "asset";
		}
		
		@RequestMapping(value ="/asset/delete/{assetid}", method = RequestMethod.GET)
		public String deletedasset(@PathVariable(name = "assetid") int assetid) {
			assetService.delete(assetid);
			return "redirect:/asset";
			
		}

		
		@RequestMapping(value = "asset/add", method = RequestMethod.GET)
		public String assetadd(ModelMap model) {
			Asset asset = new Asset();
			model.addAttribute("asset", asset);
			return "assetadded";
		}
		
		@RequestMapping(value = "/asset/saveasset", method = RequestMethod.POST)
		public String Saveasset(@Valid Asset asset, BindingResult result, 
				ModelMap model, RedirectAttributes redirectattributes) {
			if (result.hasErrors()) {
				return "assetadded";
			}
			assetService.save(asset);
			return "assetadd";
		}
				
		
		@RequestMapping(value = "/asset/update/update", method = RequestMethod.POST)
		public String UpdateAsset(@Valid Asset asset, BindingResult result, 
				ModelMap model, RedirectAttributes redirectattributes) {
			if (result.hasErrors()) {
				return "assetupdateform";
			}
			assetService.save(asset);
			return "redirect:/asset";
		}
				
			
			@RequestMapping(value = "/asset/update/{assetid}", method = RequestMethod.GET)
		    public String showEditAssetPage(@PathVariable(name = "assetid") int assetid, Model model) {
				Asset asset = assetService.get(assetid);
				model.addAttribute("asset", asset);
		        return "assetupdateform";
			}
	
}

