const express= require('express');

const app= express();

app.set('view engine', 'ejs');

app.use(express.static('public'));

app.listen(3000, () => console.log('Server running on port 3000'));

app.get('/', (req, res) => res.render('index'));

app.get('/detail/:country/:year/:month/:day', (req, res) => {
    if (JSON.stringify(req.params) === '{}') {
        res.redirect('/');
    } else {
        res.render('detail', {
            country: req.params.country,
            year: req.params.year,
            month: req.params.month,
            day: req.params.day
        });
    }
});