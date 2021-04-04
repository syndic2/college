const { body, check } = require('express-validator');

const validation= {
    login: [
        body('username', 'Username tidak boleh kosong!').notEmpty(), 
        body('password', 'Password tidak boleh kosong!').notEmpty()
    ],
    postBerita: [
        body('judul_berita', 'Judul berita tidak boleh kosong!').notEmpty(),
        body('kategori_berita', 'Kategori berita tidak boleh kosong!').notEmpty(),
        body('isi_berita', 'Isi berita tidak boleh kosong!').notEmpty().escape().trim(),
        body('tgl_berita', 'Tanggal berita tidak boleh kosong!').notEmpty()
    ]
};

module.exports= validation;