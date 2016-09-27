
/**
 * Created by sushilmainali on 25/08/2016.
 */


function addToDiv(div, item) {
    console.log("dfsddfsfsdf");
    var checBoxElm = "<label><input type='checkbox'>"+item+"</label>";
    if(div === 'ent') {
        $('#ent').append(checBoxElm);
    } else if(div === 'mus') {
        $('#mus').append(checBoxElm);
    } else if(div === 'news') {
        $('#news').append(checBoxElm);
    }
}