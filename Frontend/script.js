// script.js -> API connection to Wrapper-Backend 

const api = "http://localhost:8080/api/v1/";

function getLocationWeatherData(){
    let input = document.getElementById("input").value;
    let error = document.getElementById("error");
    error.style.display = "none";
    let display = document.getElementById("weatherBox");
    display.style.display = "none";

    // Current weather
    fetch(api + "current/weather/" + input)
        .then(r => {
            if(!r.ok){
                error.style.display ="block";
                throw new Error("City not found");
            }
            return r.json();
        })
        .then(data => {
            display.style.display = "block";
            document.getElementById("currentTemp").innerHTML = Math.round(data.temperature) + "°C";
            document.getElementById("conditionIcon").innerHTML = getConditionIcon(data.condition);
            
            document.getElementById("humidity").innerHTML = "Humidity: " + data.humidity + "%";
            document.getElementById("windSpeed").innerHTML = "Wind Speed: " + data.windSpeed + " m/s";
            document.getElementById("condition").innerHTML = "Condition: " + data.condition;
        })
        .catch(err => console.log("Error fetching weather:", err));
    
    // Weekly forecast
    fetch(api + "weekly/" + input)
        .then(r => r.json())
        .then(data => {

            data.forecast.forEach((day, index) => {

                document.getElementById("day" + (index + 1)).innerHTML =
                    day.date +
                    " <br> Min: " + Math.round(day.minTemp) +
                    "°C, Max: " + Math.round(day.maxTemp) +
                    "°C <br>" + day.condition;
            });

        })
        .catch(err => console.log("Error fetching forecast:", err));
}

// Icons, for display of the current weather
conditionIcons = {
    thunderstorm: '⛈️',
    drizzle: '🌦️',
    rain: '🌧️',
    snow: '❄️',
    clear: '☀️',
    clouds: '☁️',
    mist: '🌫️',
    smoke: '💨',
    haze: '🌫️',
    dust: '🌪️',
    fog: '🌫️',
    sand: '🌪️',
    ash: '💨',
    squall: '💨',
    tornado: '🌪️'
};

function getConditionIcon(condition){
    const key = condition.toLowerCase();
    return conditionIcons[key]
}

// "Enter" -> Display weather data from location
document.addEventListener("keypress", function(event) {
    if(event.key === "Enter") {
        getLocationWeatherData();
    }
});
