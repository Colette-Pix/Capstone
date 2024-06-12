window.onload = function() {
    var navbar = `
    <nav>
        <select onchange="location = this.value;">
            <option value="index">Select Page</option>
            <option value="index">Home</option>
            <option value="SearchForExtraterrestrialPartners">Search for Extraterrestrial Partners</option>
            <option value="system">System</option>
            <option value="PROJECT">Secret Project</option>
            <option value="access">Project Access</option>
        </select>
    </nav>
    `;

    document.body.insertAdjacentHTML('afterbegin', navbar);
}