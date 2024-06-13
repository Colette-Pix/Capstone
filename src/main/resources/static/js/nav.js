/**
 * This function is executed when the window has finished loading.
 * It creates a navigation bar with a dropdown menu that allows the user to navigate to different pages.
 * The navigation bar is inserted at the beginning of the body of the document.
 */
window.onload = function() {
    // The HTML for the navigation bar
    var navbar = `
    <nav>
        <!-- The dropdown menu -->
        <select onchange="location = this.value;">
            <!-- The default option -->
            <option value="index">Select Page</option>
            <!-- The option to navigate to the Home page -->
            <option value="index">Home</option>
            <!-- The option to navigate to the Search for Extraterrestrial Partners page -->
            <option value="SearchForExtraterrestrialPartners">Search for Extraterrestrial Partners</option>
            <!-- The option to navigate to the System page -->
            <option value="system">System</option>
            <!-- The option to navigate to the Secret Project page -->
            <option value="PROJECT">Secret Project</option>
            <!-- The option to navigate to the Project Access page -->
            <option value="access">Project Access</option>
        </select>
    </nav>
    `;

    // Insert the navigation bar at the beginning of the body of the document
    document.body.insertAdjacentHTML('afterbegin', navbar);
}