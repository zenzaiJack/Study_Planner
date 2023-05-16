// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
$.ajax({
    url: "/pie-data",
    type: "GET",
    dataType: "json",
    success: function(data) {
        var ctx = document.getElementById("myPieChart");
        
        // 데이터 개수에 따라 색상 배열 생성
        var colors = generateRandomColors(data.time.length);
        
        var myPieChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: data.subject,
                datasets: [{
                    data: data.time,
                    backgroundColor: colors, // 생성된 색상 배열 적용
                    hoverBackgroundColor: colors, // 생성된 색상 배열 적용
                    hoverBorderColor: "rgba(234, 236, 244, 1)",
                }],
            },
            options: {
                maintainAspectRatio: false,
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    caretPadding: 10,
                },
                legend: {
                    display: false
                },
                cutoutPercentage: 80,
            },
        });
    }
});

// 데이터 개수에 따라 랜덤한 색상 배열 생성하는 함수
function generateRandomColors(count) {
    var colors = [];
    
    for (var i = 0; i < count; i++) {
        var color = getRandomColor(); // 랜덤한 색상 생성
        colors.push(color);
    }
    
    return colors;
}

// 랜덤한 색상 생성하는 함수
function getRandomColor() {
    var letters = "0123456789ABCDEF";
    var color = "#";
    
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    
    return color;
}
