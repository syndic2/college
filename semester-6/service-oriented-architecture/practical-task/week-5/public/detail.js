let date= '',
    countryName= '',
    current= [],
    upcoming= [],
    previous= [];

const getCountry= () => {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: `${config.host}/countries?key=${config.api_key}&country=${params.country}`,
            method: 'GET',
            dataType: 'json',
            success: (result) => {
                resolve(result.countries[0].name);
            },
            error: (err) => {
                reject(err);
            }
        });
    });
};

const getCurrent= () => {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: `${config.host}/holidays/?key=${config.api_key}&country=${params.country}&year=${params.year}&month=${params.month}&day=${params.day}`,
            method: 'GET',
            dataType: 'json',
            success: (result) => {    
                resolve(result.holidays);
            },
            error: (err) => {
                reject(err);
            }
        });
    });
};

const getPrevious= () => {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: `${config.host}/holidays/?key=${config.api_key}&country=${params.country}&year=${params.year}&month=${params.month}&day=${params.day}&previous`,
            method: 'GET',
            dataType: 'json',
            success: (result) => {
                resolve(result.holidays);
            },
            error: (err) => {
                reject(err);
            }
        });
    });
};

const getUpcoming= () => {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: `${config.host}/holidays/?key=${config.api_key}&country=${params.country}&year=${params.year}&month=${params.month}&day=${params.day}&upcoming`,
            method: 'GET',
            dataType: 'json',
            success: (result) => {
                resolve(result.holidays);
            },
            error: (err) => {
                reject(err);
            }
        });
    });
};

const showDetail= () => {
    $('#detail_Body').html('');

    $('#detail_Body').hide();
    $('#detail_Body').fadeIn(1000);
    
    $('#detail_Body').append(`
        <h1>${date}</h1>

        Country: <span>${countryName}</span> <br>
    `);

    current.forEach((item, index) => {
        if (index === 0 && current.length > 1) {
            $('#detail_Body').append(`
                <p class="mt-4"
                    style="font-size: 2vw;">
                    ${item.name} <br> <br> & <br>
                </p>
            `);
        } else {
            $('#detail_Body').append(`
                <p class="mt-4"
                    style="font-size: 2vw;">
                    ${item.name}
                </p>
            `);
        }
    });

    $('#detail_Body').append(`
        <div class="mt-5">
            Upcoming Events: <br> <br>
    `);

    upcoming.forEach((item, index) => {
        let date= `${parseInt(item.date.split('-')[2])} ${months[parseInt(item.date.split('-')[1])-1].name} ${item.date.split('-')[0]}`;

        if (index === 0 && upcoming.length > 1) {
            $('#detail_Body').append(`
                <span>
                    <b>${date} - ${item.name}</b>
                </span> <br>
            `);
        } else {
            $('#detail_Body').append(`
                <span>
                    <b>${date} - ${item.name}</b>
                </span>
            `);
        }
    });

    $('#detail_Body').append(`    
            <br> <br> <br> 

            Previous Events: <br> <br>
    `);

    previous.forEach((item, index) => {
        let date= `${parseInt(item.date.split('-')[2])} ${months[parseInt(item.date.split('-')[1])-1].name} ${item.date.split('-')[0]}`;

        if (index === 0 && previous.length > 1) {
            $('#detail_Body').append(`
                <span>
                    <b>${date} - ${item.name}</b>
                </span> <br>
            `);
        } else {
            $('#detail_Body').append(`
                <span>
                    <b>${date} - ${item.name}</b>
                </span>
            `);
        }
    });

    $('#detail_Body').append(`
        </div>
    `);
};

$(document).ready(function() {
    date= `${params.day} ${months[params.month-1].name} ${params.year}`;

    $('#detail_Body').html('Getting data, please wait...');

    getCountry().then(country => {
        countryName= country;
        
        getCurrent().then(holiday => {
            current= holiday;

            getPrevious().then(holiday => {
               previous= holiday;

                getUpcoming().then(holiday => {
                    upcoming= holiday;

                    showDetail();
                });
            })
        })
    })
});