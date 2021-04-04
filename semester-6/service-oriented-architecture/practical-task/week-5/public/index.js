let holidays= [];

let selectedCountry= 'AD',
    selectedYear= 1990,
    selectedMonth= 0,
    selectedDay= 0;

const setCountries= () => {
    $.ajax({
        url: `${config.host}/countries?key=${config.api_key}`,
        method: 'GET',
        dataType: 'json',
        success: (result) => {
            let option;

            result.countries.forEach(item => {
                option+= `
                    <option value="${item.code}">
                        ${item.name}
                    </option>
                `;
            });

            $('#cb_Countries').append(option);
        }
    });
};

const setYears= () => {
    let option;

    for (let i= 1990; i<2026; i++) {
        option+= `<option>${i}</option>`;
    }

    $('#cb_Years').append(option);
};

const setMonthYear= () => {
    $('#lbl_MonthYear').hide();
    $('#lbl_MonthYear').fadeIn();
    $('#lbl_MonthYear').text(`${months[selectedMonth].name} ${selectedYear}`);
};

const getHolidays= () => {
    if (selectedYear === 2019) {
        $('#pleaseWait').hide();
        $('#pleaseWait').fadeIn(1000);
        $('#pleaseWait').text('Getting data, please wait...');

        $.ajax({
            url: `${config.host}/holidays?key=${config.api_key}&country=${selectedCountry}&year=${selectedYear}&month=${selectedMonth+1}`,
            method: 'GET',
            dataType: 'json',
            success: (result) => {
                holidays= result.holidays;
                
                console.log(holidays);

                $('#pleaseWait').fadeOut(1000);
                $('#pleaseWait').html('');
                    
                setMonthYear();
                showCalendar();
            }
        });
    } else {
        setMonthYear();
        showCalendar();
    }
};

const showCalendar= () => {
    let month= months[selectedMonth];

    if (month) {
        $('#calendar_Body').html('');

        let daysInMonth= [];

        for (let i= 0; i<month.day; i++) {
            daysInMonth.push({
                day: (i+1),
                holiday: [],
                color: 'black'
            });

            for (let j= 0; j<holidays.length; j++) {
                let date= parseInt(holidays[j].date.split('-')[2]);

                if (date === daysInMonth[i].day) {
                    daysInMonth[i].holiday.push(holidays[j].name);
                    daysInMonth[i].color= 'red';
                }
            }
        }

        //if (selectedYear === '2019') console.log(daysInMonth);

        let index= 0,
            tr= ``;

        for (let i= 0; i<6; i++) {
            let td= ``;

            for (let j= 0; j<7; j++) {
                if (i === 0 && j === 0) {
                    td+= `<td></td>`;
                } else {
                    if (daysInMonth[index]) {
                        if (selectedYear === 2019) {
                            if (daysInMonth[index].holiday.length) {
                                td+= `
                                        <td>
                                            <a href="http://localhost:3000/detail/${selectedCountry}/${selectedYear}/${selectedMonth+1}/${daysInMonth[index].day}" 
                                            style="color: red;">
                                                <div class="calendar_Row" 
                                                     style="color: ${daysInMonth[index].color};">
                                                    ${daysInMonth[index].day} <br>
                                `

                                daysInMonth[index].holiday.forEach((item, idx) => {
                                    if (idx === 0 && daysInMonth[index].holiday.length > 1){
                                        td+= `${item} <br> & <br>`;
                                    } else {
                                        td+= `${item}`;
                                    }
                                });

                                td+= `
                                            </div>
                                        </a>                                    
                                    </td>
                                `
                            } else {
                                td+= `
                                    <td>
                                        <a href="http://localhost:3000/detail/${selectedCountry}/${selectedYear}/${selectedMonth+1}/${daysInMonth[index].day}" 
                                            style="color: red;">
                                            <div class="calendar_Row" 
                                                style="color: ${daysInMonth[index].color};">
                                                ${daysInMonth[index].day}   
                                            </div>
                                        </a>
                                    </td>
                                `;
                            } 
                        } else {
                            td+= `
                                <td>
                                    <div class="calendar_Row">
                                        ${daysInMonth[index].day}                                        
                                    </div>
                                </td>
                            `;
                        }

                        index++;
                    }
                }
            }

            tr+=`<tr>${td}</tr>`;
        }

        $('#calendar_Body').append(tr);
        $('.calendar_Row').hide();
        $('.calendar_Row').fadeIn(1000);
    }
};

$(document).ready(function() {
    setCountries();
    setYears();
    getHolidays();

    $('#cb_Countries').change(function() {
        selectedCountry= $(this).children('option:selected').val();

        getHolidays();
    });

    $('#cb_Years').change(function() {
        selectedYear= parseInt($(this).val());

        getHolidays();
    });

    $('#btn_Prev').click(function() {
        selectedMonth= selectedMonth > 0 ? selectedMonth - 1 : selectedMonth;

        getHolidays();
    });

    $('#btn_Next').click(function() {
        selectedMonth= selectedMonth < 11 ? selectedMonth + 1 : selectedMonth;
        
        getHolidays();
    });
});