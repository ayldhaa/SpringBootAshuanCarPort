//axios封装post请求
function axiosPostRequst(url,data) {
    let baseUrl ="http://localhost:8091";
    let result = axios({
        method: 'post',
        url: `${baseUrl}${url}`,
        data: data,
        transformRequest:[function(data){
            let ret = '';
            for(let i in data){
                ret += encodeURIComponent(i)+'='+encodeURIComponent(data[i])+"&";
            }
            return ret;
        }],
        header:{
            'Content-Type':'application/json'
        }
    }).then(resp=> {
        return resp.data;
}).catch(error=>{
        return "exception="+error;
});
    return result;
}

//get请求
function axiosGetRequst(url) {
    var result = axios({
        method: 'get',
        url: url
    }).then(function (resp) {
        return resp.data;
    }).catch(function (error) {
        return "exception=" + error;
    });
    return result;
}