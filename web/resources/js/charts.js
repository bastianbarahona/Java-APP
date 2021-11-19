/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global Highcharts */

Highcharts.chart('containerChart', {
  chart: {
    type: 'column'
  },
  title: {
    text: 'Total de Cientes Registrados. Julio, 2019'
  },
  subtitle: {
    text: 'Haga clic en las columnas. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
  },
  xAxis: {
    type: 'category'
  },
  yAxis: {
    title: {
      text: 'Total Cientes'
    }

  },
  legend: {
    enabled: false
  },
  plotOptions: {
    series: {
      borderWidth: 0,
      dataLabels: {
        enabled: true,
        format: '{point.y}'
      }
    }
  },

  tooltip: {
    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b> en total<br/>'
  },

  series: [{
    name: "Clientes",
    colorByPoint: true,
    data: [{
        name: "Empresa",
        y: 56,
        drilldown: "Empresa"
      },

      {
        name: "Natural",
        y: 5,
        drilldown: "Natural"
      }
    ]
  }],
  drilldown: {
    series: [{
        name: "Empresa",
        id: "Empresa",
        data: [
          [
            "JUAN",
            1.0
            
          ],
          [
            "v64.0",
            1.3
          ],
          [
            "v63.0",
            53.02
          ],
          [
            "v62.0",
            1.4
          ],
          [
            "v61.0",
            0.88
          ],
          [
            "v60.0",
            0.56
          ],
          [
            "v59.0",
            0.45
          ],
          [
            "v58.0",
            0.49
          ],
          [
            "v57.0",
            0.32
          ],
          [
            "v56.0",
            0.29
          ],
          [
            "v55.0",
            0.79
          ],
          [
            "v54.0",
            0.18
          ],
          [
            "v51.0",
            0.13
          ],
          [
            "v49.0",
            2.16
          ],
          [
            "v48.0",
            0.13
          ],
          [
            "v47.0",
            0.11
          ],
          [
            "v43.0",
            0.17
          ],
          [
            "v29.0",
            0.26
          ]
        ]
      },
      {
        name: "Natural",
        id: "Natural",
        data: [
          [
            "v11.0",
            6.2
          ],
          [
            "v10.0",
            0.29
          ],
          [
            "v9.0",
            0.27
          ],
          [
            "v8.0",
            0.47
          ]
        ]
      }
    ]
  }
});
