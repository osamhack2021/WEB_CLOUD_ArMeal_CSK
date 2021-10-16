import React from "react";
import { Doughnut } from "react-chartjs-2"

function DoughnutChart({chartData, width}) {
  const data = {
    labels: [
      '싫어요',
      '별로예요',
      '보통이에요',
      '맛있어요',
      '최고예요',
    ],
    datasets: [{
      data: chartData,
      // '#EDD500',
      // '#FF9F40',
      // '#EC5500',
      // '#FF2E00',
      // 'RED',
      backgroundColor: [
        '#36A2EB',
        '#4BC0C0',
        '#FFCD56',
        '#FF9F40',
        '#FF6384',
      ]
    }],
  };

  const options = {
    responsive: true,
    maintainAspectRatio: true,
    plugins: {
      legend: {
        display: false
      }
    }
  }
  
  return (
    <Doughnut data={data} width={width} options={options}/>
  )
}

export default DoughnutChart;