console.log("Script Loaded");

// change theme work 
let currentTheme = getTheme();
// initial--> 
document.addEventListener('DOMContentLoaded', () =>{
  changeTheme();
});

function changeTheme() {

  changePageTheme(currentTheme, currentTheme);

  // set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");
  
  //change the text of button
  changeThemeButton.querySelector("span").textContent =
    currentTheme == "light" ? "dark" : "light";

  changeThemeButton.addEventListener("click", (event) => {
    const oldTheme = currentTheme;
    console.log("changed theme button clicked");
    if (currentTheme == "dark") {
      // change to light
      currentTheme = "light";
    } else {
      // change to dark
      currentTheme = "dark";
    }

    changePageTheme(currentTheme, oldTheme);
  });
}

// set theme to local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// get theme from local storage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light"; 
}

// change current page theme
function changePageTheme(theme, oldTheme) {
  // update local storage
  setTheme(theme);
  // remove the old theme
  document.querySelector("html").classList.remove(oldTheme);
  // set the new theme
  document.querySelector("html").classList.add(theme);

  document.querySelector("#theme_change_button").querySelector("span").textContent =
    theme == "light" ? "dark" : "light";
}

//end of change theme work