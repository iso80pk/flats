package piotrek.k.flats.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;

import piotrek.k.flats.Application.GroupMenagerService;
import piotrek.k.flats.DTO.REST.Group;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.UserService;

@RestController
@RequestMapping(value = "/api")
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class GroupsRESTController {

	@Autowired
	UserService userService;

	@Autowired
	GroupMenagerService groupMenagerService;

	@GetMapping(value = "/group", produces = "application/json")
	public ResponseEntity<Map<Integer, Group>> getGroups() {
		return new ResponseEntity<Map<Integer, Group>>(groupMenagerService.getGroupsByLoggedUser(), HttpStatus.OK);

	}

	// @PostMapping(value = "/group")
	// @RequestMapping(method = RequestMethod.POST, path = "/group", produces =
	// "APPLICATION_JSON_VALUE")
	// public ResponseEntity<Map<Integer, Group>> saveGroups(@RequestBody
	// Map<Integer, Group> groups) {
	// return new ResponseEntity<Map<Integer,
	// Group>>(groupMenagerService.saveGroups(groups), HttpStatus.OK);
	//
	// }

	@PostMapping(value = "/group", produces = "application/json", consumes = "application/json")
	public @ResponseBody Map<Integer, Group> saveGroups(@RequestBody String groups) {
		Map<Integer, Group> map = new HashMap<Integer, Group>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			// convert JSON string to Map
			map = mapper.readValue(groups, new TypeReference<Map<Integer, Group>>(){});
			System.out.println(map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return groupMenagerService.saveGroups(map);
	}

}
