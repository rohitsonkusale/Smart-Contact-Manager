console.log("Script Loaded");

let currentTheme = getTheme();

changeTheme();

function changeTheme() {

    changePageTheme(currentTheme, currentTheme)
  document.querySelector("html").classList.add(currentTheme);

  // set the listener to change theme buttton
  const changeThemeButton = document.querySelector("#theme_change_button");
  changeThemeButton.addEventListener("click", (event) => {
    const odlTheme = currentTheme;
    console.log("changed theme button clicked");
    if (currentTheme == "dark") {
      // change to light
      currentTheme = "light";
    } else {
      // change to dark
      currentTheme = "dark";
    }

    
  });
}

// set theme to local sttorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// get theme from local storage
function getTheme() {
  let theme = localStorage.getItem("theme");
  if (theme) {
    return theme;
  } else {
    return "light";
  }
}

// change current page theme
function changePageTheme(theme, odlTheme) {
    // local storage me  update karenge
    setTheme(currentTheme);
    // remove the current theme
    document.querySelector("html").classList.remove(odlTheme);
    // set the current theme
    document.querySelector("html").classList.add(theme);

    //change the text of button
    changeThemeButton.querySelector("span").textContent =
    theme == "light" ? "dark" : "light";
}