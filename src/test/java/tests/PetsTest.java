package tests;

import common.BasePage;
import org.testng.annotations.Test;

public class PetsTest extends BasePage {

    @Test(description = "Pets lifecycle")
    public void TestPetsLifecycle() throws InterruptedException {
        profile.openProfile();
        profile.clickPets();
        String petName = pets.addNewPet();
        pets.openPet(petName);
        pets.checkingTreeDots(petName);
        String newPetName = pets.editPet();
        pets.deletePet(newPetName);
    }
}
