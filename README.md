The Happy Home is a web-based inventory management application designed 
to help manage parts and products for a home furniture business. 
This system provides a user-friendly interface for viewing, adding, and 
purchasing items, ensuring inventory is tracked and validated effectively.
C. Mainscreen Enhancements
Branding & Headers

Line 14: "The Happy Home" added in <title> tag.

Line 19: "The Happy Home" displayed in <h1>.

Line 21–22: Section headers updated to "Happy Home Parts" and "Happy Home Pieces".

Line 53–54: Product listings titled as "Happy Home Products" and"Happy Home Furniture".

D. About Page
About.html

Created under the templates folder.

Lines 8–10: Includes a welcoming message and a link to return to the main screen.

Mainscreen.html

Line 20: Added a navigation link to the About page.

AboutController

Added under controllers to handle mapping and message delivery.

E. Data & Configuration
application.properties

Line 6: Database name updated.

BootStrapData

Lines 7, 37, 41: Added InhousePartRepository and stored it in a variable.

Lines 47–119: Inserts sample parts/products only if repositories are empty.

F. Purchasing Functionality
Mainscreen.html

Line 87: "Buy Now" button added for products.

AddProductController

Lines 177–189: New method to check if a product is in stock. On successful purchase, inventory is reduced by one.

Success & Failure Pages

success.html and failure.html created to inform users of purchase outcome.

G. Inventory Validation
Part.java

Lines 50–51, 59–60: Added min and max fields.

Lines 103–114: Getters and setters for min and max.

BootStrapData

Lines 30–33: Added annotations for min and max.

Lines 36–37: Declared minInv and maxInv variables.

Lines 138–145: Initially added InventoryValidation method (later removed).

Forms

InhousePartForm.html (Lines 27–30) and OutsourcedPartForm.html (Lines 25–28): Fields for min/max inventory added.

Both forms updated with labels/placeholders for all inputs (Lines 1–33).

Mainscreen.html

Lines 39–40 and 49–50: Displayed min/max inventory columns.

Service Implementations

Inventory validation initially added in PartServiceImpl, InhousePartServiceImpl, and OutsourcedPartServiceImpl (later removed).

H. Validation & Error Handling
AddInhousePartController / AddOutsourcedPartController

Lines 43–55 (Inhouse) and 46–57 (Outsourced): Validates min/max inventory and displays relevant errors using BindingResult.

EnufPartsValidator

isValid() refactored:

Skips products already added.

Uses available and required part counts for validation.

Adds a custom error if insufficient parts are available.

Removed (due to refactor or redundancy):

Inventory validation calls in service layer.

InventoryValidation() method and related logic.

I. Testing & Dependencies
pom.xml

Lines 23–29: Added required dependency.

PartTest.java

Lines 162–179: Two unit tests added — hasMinimumInventory() and hasMaximumInventory().

J. Cleanup
Removed Files

InventoryValidator.java, MinValidator.java, MaxValidator.java, ValidInventory.java, and all related annotations.

DeletePartValidator and ValidDeletePart — deemed unnecessary.

