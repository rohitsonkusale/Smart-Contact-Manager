console.log("Script Loaded")

let currentTheme = getTheme();

changeTheme()

function changeTheme(){
    document.querySelector("html").classList.add(currentTheme);
}

// set theme to local sttorage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}

// get theme from local storage 
function getTheme(){
    let theme =  localStorage.getItem("theme");
    if(theme){
        return theme;
    }
    else {
        return "light";
    }
}