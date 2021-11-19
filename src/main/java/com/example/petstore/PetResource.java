package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource {
	List<Pet> pets = new ArrayList<Pet>();
	List<Pet> petstype = new ArrayList<Pet>();

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@Path("/getpets")
	@GET
	public Response getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		pets = PetStore.getInstance().getPets();
		return Response.ok(pets).build();
//		Pet pet1 = new Pet();
//		pet1.setPetId(1);
//		pet1.setPetAge(3);
//		pet1.setPetName("Boola");
//		pet1.setPetType("Dog");
//
//		Pet pet2 = new Pet();
//		pet2.setPetId(2);
//		pet2.setPetAge(4);
//		pet2.setPetName("Sudda");
//		pet2.setPetType("Cat");
//
//		Pet pet3 = new Pet();
//		pet3.setPetId(3);
//		pet3.setPetAge(2);
//		pet3.setPetName("Peththappu");
//		pet3.setPetType("Bird");
//
//		pets.add(pet1);
//		pets.add(pet2);
//		pets.add(pet3);

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@GET
	@Path("getpets/{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Pet petbyid = new Pet();
		petbyid = PetStore.getInstance().getPet(petId);

//		pet.setPetId(petId);
//		pet.setPetAge(3);
//		pet.setPetName("Buula");
//		pet.setPetType("Dog");

		return Response.ok(petbyid).build();
		
	}

//	@APIResponses(value = {
//			@APIResponse(responseCode = "200", description = "Create Pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
//	@Path("/createpet")
//	@POST
//	@Produces("application/json")
//	public Response createPet(Pet pet) {
//		List<Pet> pets = new ArrayList<Pet>();
//		pets = PetStore.getInstance().createPet(pet);
//		return Response.ok(pets).build();
//	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Create a Pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@POST
	@Path("/createpet")
	public Response createPet(Pet pet) {

		List<Pet> pets = new ArrayList<Pet>();
		if( pet.getPetName() != null && pet.getPetAge() != null && pet.getPetType() != null){
			pets = PetStore.getInstance().createPet(pet);
			return Response.ok(pets).build();
		}else{
			return Response.ok("{\n" + "\"successful\":false\n" + "}").build();

		}
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@PUT
	@Path("updatepet/{petId}")
	@Produces("application/json")
	public Response UpdatePet(@PathParam("petId") int petId,Pet pet) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		List<Pet> updateByPet = new ArrayList<Pet>();
		//Pet updateByPet = new Pet();
		updateByPet = PetStore.getInstance().updatePet(petId,pet);

		return Response.ok(updateByPet).build();

	}
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@DELETE
	@Path("deletepet/{petId}")
	@Produces("application/json")
	public Response DeletePet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		List<Pet> deleteAfPet = new ArrayList<Pet>();
		//Pet deleteAfPet = new Pet();
		deleteAfPet = PetStore.getInstance().deletePet(petId);

		return Response.ok(deleteAfPet).build();

	}

	// ~~~~~~~~~ Pet Types ~~~~~~~~~~

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@Path("/getpetstype")
	@GET
	public Response getPetsType() {
		List<PetType> petstype = new ArrayList<PetType>();
		petstype = PetStore.getInstance().getPetsType();
		return Response.ok(petstype).build();
	}


	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@GET
	@Path("getpetstype/{petTypeId}")
	public Response getPetType(@PathParam("petTypeId") int petTypeId) {
		if (petTypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		PetType petTypebyid = new PetType();
		petTypebyid = PetStore.getInstance().getPetType(petTypeId);

//		pet.setPetId(petId);
//		pet.setPetAge(3);
//		pet.setPetName("Buula");
//		pet.setPetType("Dog");

		return Response.ok(petTypebyid).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@PUT
	@Path("updatepetstype/{petTypeId}")
	@Produces("application/json")
	public Response UpdatePetType(@PathParam("petTypeId") int petTypeId,PetType pettype) {
		if (petTypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		List<PetType> updateByPetType = new ArrayList<PetType>();
		//Pet updateByPet = new Pet();
		updateByPetType = PetStore.getInstance().UpdatePetType(petTypeId,pettype);

		return Response.ok(updateByPetType).build();

	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Create Pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@Path("/createpetsType")
	@POST
	@Produces("application/json")
	public Response createPetType(PetType pettype) {
		List<PetType> petstype = new ArrayList<PetType>();
		petstype = PetStore.getInstance().createPetType(pettype);
		return Response.ok(petstype).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@DELETE
	@Path("deletepetstype/{petTypeId}")
	@Produces("application/json")
	public Response DeletePetType(@PathParam("petTypeId") int petTypeId) {
		if (petTypeId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		List<PetType> deleteAfPetType = new ArrayList<PetType>();
		//Pet deleteAfPet = new Pet();
		deleteAfPetType = PetStore.getInstance().deletePetType(petTypeId);

		return Response.ok(deleteAfPetType).build();

	}


	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "delete pet", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("/search")
	public Response searchPet(@DefaultValue("-1") @QueryParam("id") int petId,
							  @DefaultValue("null") @QueryParam("name") String petName,
							  @DefaultValue("0") @QueryParam("age") int petAge)
	{
		boolean isPetFound = false;
		int id = 0;

		if(petId != -1 && petName.equals("null") && petAge == 0){
			if (petId < 0) {
				return Response.status(Status.NOT_FOUND).build();
			}

			for (int i=0;i<PetStore.getInstance().getPets().size();i++){
				if(petId == PetStore.getInstance().getPets().get(i).getPetId()){
					isPetFound = true;
					id = i;
				}
			}
			if(isPetFound){
				return Response.ok(PetStore.getInstance().getPets().get(id)).build();
			}else{
				return Response.ok("There is no pet with id = "+petId).build();
			}
		}
		else if(petId == -1 && !petName.equals("null") && petAge == 0){
			for (int i=0;i<PetStore.getInstance().getPets().size();i++){
				if(petName.equals(PetStore.getInstance().getPets().get(i).getPetName())){
					isPetFound = true;
					id = i;
				}
			}
			if(isPetFound){
				return Response.ok(PetStore.getInstance().getPets().get(id)).build();
			}else{
				return Response.ok("There is no pet with name = "+petName).build();
			}
		}
		else if(petId == -1 && petName.equals("null") && petAge != 0){
			List<Pet> temp = new ArrayList<Pet>();
			for (int i=0;i<PetStore.getInstance().getPets().size();i++){
				if(petAge == PetStore.getInstance().getPets().get(i).getPetAge()){
					isPetFound = true;
					id = i;
					temp.add(PetStore.getInstance().getPets().get(id));
				}
			}
			if(isPetFound){
				return Response.ok(temp).build();
			}else{
				return Response.ok("There is no pet with age = "+petAge).build();
			}
		}
		else{
			return Response.status(Status.NOT_FOUND).build();
		}
	}


}
