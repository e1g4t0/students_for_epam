function setDeleteId(productId){
    document.getElementById('confirmDelete').href
        =`delete?id=${productId}`;
}

function setEditData(productId){
    $.ajax({
        url: `update?id=${productId}`
    }).done(function(res){
        console.log(res);
        let data = JSON.parse(res);
        console.log(data);
        document.getElementById("name").value = data.name;
        document.getElementById("surname").value = data.surname;
        document.getElementById("group").value = data.group;
        document.getElementById("year").value = data.year;
        document.getElementById('updId').value = data.id;
    })
}
