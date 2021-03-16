package auto_radnja;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class VulkanizerskaRadnjaTest extends RadnjaTest {

	@BeforeEach
	void setUp() throws Exception {
		vulkanizerskaRadnja = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		vulkanizerskaRadnja = null;
	}

}
