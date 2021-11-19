package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private static PetStore petInstance;
    public List<Pet>  pet_list = new ArrayList<Pet>();
    int petId = 4;
    public List<PetType>  pet_type_list = new ArrayList<PetType>();
    int petTypeId = 4;

    private PetStore(){
        Pet pet1 = new Pet();
        pet1.setPetId(1);
        pet1.setPetAge(3);
        pet1.setPetName("Boola");
        pet1.setPetType("Dog");

        Pet pet2 = new Pet();
        pet2.setPetId(2);
        pet2.setPetAge(4);
        pet2.setPetName("Sudda");
        pet2.setPetType("Cat");

        Pet pet3 = new Pet();
        pet3.setPetId(3);
        pet3.setPetAge(2);
        pet3.setPetName("parrot");
        pet3.setPetType("Bird");

        pet_list.add(pet1);
        pet_list.add(pet2);
        pet_list.add(pet3);

        PetType pettype1 = new PetType();
        pettype1.setPetTypeId(1);
        pettype1.setPetTypeName("Dog");

        PetType pettype2 = new PetType();
        pettype2.setPetTypeId(2);
        pettype2.setPetTypeName("Cat");

        PetType pettype3 = new PetType();
        pettype3.setPetTypeId(3);
        pettype3.setPetTypeName("Bird");

        pet_type_list.add(pettype1);
        pet_type_list.add(pettype2);
        pet_type_list.add(pettype3);
    }

    public static PetStore getInstance() {
        if (petInstance == null)
            petInstance = new PetStore();
        return petInstance;
    }

    public List<Pet> getPets(){
        return pet_list;
    }

    public Pet getPet(int petId){
        for(Pet pet:pet_list){
            if(pet.getPetId()==petId){
                return pet;
            }
        }
        return null;
    }
    public List<Pet> createPet(Pet pet){

//        pet.setPetId(pet_list.get(pet_list.size()-1).getPetId()+1);
//        pet_list.add(pet);
//        return  pet_list;
        pet.setPetId(petId);
        petId++;
        pet_list.add(pet);
        return pet_list;
    }

    public List<Pet> updatePet(int petId,Pet petUp){
        for(Pet pet:pet_list){
            if(pet.getPetId()==petId){

                //pet_list.set(petId-1,petUp);

                pet.setPetType(petUp.getPetType());
                pet.setPetAge(petUp.getPetAge());
                pet.setPetName(petUp.getPetName());
                return pet_list;
            }
        }
        return null;
    }

    public List<Pet> deletePet(int petId){
        for(Pet pet:pet_list){
            if(pet.getPetId()==petId){
                pet_list.remove(pet);
                return pet_list;
            }
        }

        return pet_list;
    }

    // ~~~~~~~~~ Pet Types ~~~~~~~~~~

    public List<PetType> getPetsType(){
        return pet_type_list;
    }

    public PetType getPetType(int petTypeId){
        for(PetType pettype:pet_type_list){
            if(pettype.getPetTypeId()==petTypeId){
                return pettype;
            }
        }
        return null;
    }

    public List<PetType> UpdatePetType(int petTypeId,PetType petTypeUp){
        for(PetType pettype:pet_type_list){
            if(pettype.getPetTypeId()==petTypeId){

                //pet_list.set(petId-1,petUp);
//
//                pettype.setPetType(petUp.getPetType());
//                pettype.setPetAge(petUp.getPetAge());
                pettype.setPetTypeName(petTypeUp.getPetTypeName());
                return pet_type_list;
            }
        }
        return null;
    }

    public List<PetType> createPetType(PetType pettype){
        pettype.setPetTypeId(petTypeId);
        petTypeId++;
        pet_type_list.add(pettype);
        return pet_type_list;
    }

    public List<PetType> deletePetType(int petTypeId){
        for(PetType pettype: pet_type_list){
            if(pettype.getPetTypeId()==petTypeId){
                pet_type_list.remove(pettype);
                return pet_type_list;
            }
        }

        return null;
    }

}
