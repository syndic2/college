const express= require('express');
const app= express();

app.use(express.urlencoded({ extended : true }));
app.set('view engine', 'ejs');
app.listen(8080);

app.get('/', (req, res) => res.render('kalkulatorBilangan'));
app.get('/kalkulatorBilanganPage', (req, res) => res.render('kalkulatorBilangan'));
app.get('/kalkulatorTanggalPage', (req, res) => res.render('kalkulatorTanggal'));
app.get('/kalkulatorDecimalOctalPage', (req, res) => res.render('kalkulatorDecimalOctal'));

app.post('/calculateBilangan', (req, res) => {
    let result= '';

    if (req.body.val1 !== '' && req.body.val2 !== '' && req.body.operator !== '') {
        let val1= parseFloat(req.body.val1);
        let val2= parseFloat(req.body.val2);
        let count= 0;

        if (req.body.operator === 'add') {
            count= val1+val2;    
        } else if (req.body.operator === 'minus') {
            count= val1-val2;
        } else if (req.body.operator === 'multiply') {
            count= val1*val2;
        } else if (req.body.operator === 'division') {
            count= val1/val2;
        }
        
        result= `Hasilnya adalah ${count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.')}`;
    } else {
        result= `Field tidak boleh kosong`;
    }

    res.render('kalkulatorBilangan', { result: result });
});

app.post('/calculateTanggal', (req, res) => {
    let result= { };

    if (req.body.val1 !== '' && req.body.val2 !== '') {
        let startDate= req.body.val1.split('-').reverse();
        let endDate= req.body.val2.split('-').reverse();

        for (let i = 0; i < startDate.length; i++) startDate[i]= parseInt(startDate[i]);
        for (let i = 0; i < endDate.length; i++) endDate[i]= parseInt(endDate[i]);

        //SWAP TANGGAL
        if (startDate[2] >= endDate[2]) { //TAHUN
            if (startDate[1] >= endDate[1]) { //BULAN
                if (startDate[0] >= endDate[0] || startDate[0] <= endDate[0]) { //HARI
                    let tempDate= startDate;
                    startDate= endDate;
                    endDate= tempDate;
                }
            }
        }

        let beetwen= {
            day: Math.abs(endDate[0]-startDate[0]),
            month: Math.abs(endDate[1]-startDate[1]),
            year: endDate[2]-startDate[2]
        };
        
        result.days= beetwen.year*365+beetwen.month*30+beetwen.day;

        let converted= { 
            month: 0,   
            week: 0,
            day: 0 
        };

        converted.month= Math.floor(result.days/30);
        
        let yearDays= 0;
        
        if (converted.month > 12) {
            yearDays= Math.ceil(((converted.month*30)/365))+(converted.month*30)-5;
        } else if (converted.month < 12) {
            yearDays= converted.month*30;
        } else if (converted.month === 12) {
            yearDays= 365;
        }
        
        converted.week= Math.floor((result.days-yearDays)/7);
        converted.day= converted.week > 0 ? Math.floor((result.days-yearDays)-converted.week*7) : beetwen.day;

        result.days= `Perbedaannya adalah ${result.days.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.')} hari`;
        result.converted= `${converted.month} Bulan ${converted.week} Minggu ${converted.day} Hari`;

    } else {
        result.error= 'Field tidak boleh kosong';
    }

    res.render('kalkulatorTanggal', { result : result });
});

app.post('/calculateDecimalOctal', (req, res) => {
    let result= '';
    
    if (req.body.val !== '' && req.body.type !== '') {
        let val= parseInt(req.body.val);
        
        if (req.body.type === 'decToOct') {
            let divider= val;
            let remainder= 0;
            let converted= '';
            
            while (divider > 0) {
                remainder= val%8;
                val= Math.floor(val/8);
                divider= val;
                converted+= remainder.toString();
            }

            converted= parseInt(converted.split('').reverse().join(''));
            result= `Hasilnya adalah ${converted.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.')}`;
        } else if (req.body.type === 'octToDec') {
            let divided= val.toString().split('').reverse();
            let converted= 0;

            for (let i = 0; i < divided.length; i++) {
                let dividedVal= parseInt(divided[i]);

                converted+= dividedVal*Math.pow(8, i);
            }

            result= `Hasilnya adalah ${converted.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.')}`;
        }
    } else {
        result= 'Field tidak boleh kosong';
    }

    res.render('kalkulatorDecimalOctal', { result : result });
});

console.log('Server running at port 8080');