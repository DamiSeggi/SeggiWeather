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
            document.getElementById("currentCondition").innerHTML = "Condition: " + data.condition;
            
            document.getElementById("humidity").innerHTML = "Humidity: " + data.humidity + "%";
            document.getElementById("windSpeed").innerHTML = "Wind Speed: " + data.windSpeed + " m/s";
            document.getElementById("condition").innerHTML = "Condition: " + data.condition;
        })
        .catch(err => console.log("Error fetching weather:", err));
    
    // Weekly forecast
    fetch(api + "weekly/" + input)
        .then(r => r.json())
        .then(data => {
            for (let i = 1; i <= 6; i++) {
                let dateKey = "day" + i + "Date";
                let minKey = "day" + i + "MinTemp";
                let maxKey = "day" + i + "MaxTemp";
                let condKey = "day" + i + "Condition";
                
                let date = data[dateKey];
                let minTemp = Math.round(data[minKey]);
                let maxTemp = Math.round(data[maxKey]);
                let condition = data[condKey];
                
                document.getElementById("day" + i).innerHTML = 
                    date + " </br> Min: " + minTemp + "°C, Max: " + maxTemp + "°C </br>" + condition;
            }
        })
        .catch(err => console.log("Error fetching forecast:", err));
}

