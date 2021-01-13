const fs = require('fs');
const folderPath = '.';

fs.readdir(
    folderPath,
    (err, files) => {
        files.forEach(
            file => {
                console.log('ok');
                console.log(file);
            }
        );
    }
)
