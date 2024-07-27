const gulp = require('gulp');
const { exec } = require('child_process');

// Tarefa para servir o aplicativo Angular
gulp.task('serve', function (cb) {
    exec('ng serve', function (err, stdout, stderr) {
        console.log(stdout);
        console.error(stderr);
        cb(err);
    });
});

// Tarefa padrão
gulp.task('default', gulp.series('serve'));
