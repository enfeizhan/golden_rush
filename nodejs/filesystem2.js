const fs = require('fs');
// fs.mkdir('tutorial', (err)=>{
//     if (err) {
//         console.log(err);
//     } else {
//         fs.rmdir('tutorial', (err)=> {
//             if(err) {
//                 console.log(err);
//             } else {
//                 console.log('success deleted');
//             }
//         });
//     }
// });
fs.readdir('.', (err, files) => {
    if (err) {
        console.log(err)
    } else {
        console.log(files)
    }
});
