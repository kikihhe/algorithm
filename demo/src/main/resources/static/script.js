// 查询商品
function searchGoods() {
    const name = document.getElementById("searchInput").value;
    fetch(`http://localhost:8080/good/get?name=${name}`)
        .then(response => response.json())
        .then(data => {
            if (data.code === 1) {
                renderGoodsTable(data.data);
            }
        });
}

// 渲染商品表格
function renderGoodsTable(data) {
    const goodsList = document.getElementById("goodsList");
    goodsList.innerHTML = "";
    data.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.count}</td>
            <td>${item.description}</td>
            <td>
                <button onclick="editGoods(${item.id})">编辑</button>
                <button onclick="deleteGoods(${item.id})">删除</button>
            </td>
        `;
        goodsList.appendChild(row);
    });
}

// 打开新增表单
function openAddForm() {
    document.getElementById("addForm").style.display = "block";
}

// 关闭新增表单
function closeAddForm() {
    document.getElementById("addForm").style.display = "none";
}

// 删除商品
function deleteGoods(id) {
    fetch(`http://localhost:8080/good/delete?id=${id}`, {method: "DELETE"})
        .then(response => response.json())
        .then(data => {
            if (data.code === 1) {
                alert("删除成功");
                searchGoods();
            }
        });
}

// 新增商品
function addGoods() {
    const addName = document.getElementById("addName").value;
    const addPrice = document.getElementById("addPrice").value;
    const addCount = document.getElementById("addCount").value;
    const addDescription = document.getElementById("addDescription").value;

    const requestBody = {
        name: addName,
        price: addPrice,
        count: addCount,
        description: addDescription,
    };

    fetch("http://localhost:8080/good/add", {
        method: "POST",
        body: JSON.stringify(requestBody),
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => response.json())
        .then(data => {
            if (data.code === 1) {
                alert("新增成功");
                resetAddForm();
            } else {
                alert(data.message)
            }
            searchGoods();
        });
}


//  页面加载时进行一次查询
searchGoods();

// 重置新增表单
function resetAddForm() {
    document.getElementById("addName").value = "";
    document.getElementById("addPrice").value = "";
    document.getElementById("addCount").value = "";
    document.getElementById("addDescription").value = "";
}

// 全局变量用于存储当前正在编辑的商品ID
let currentEditItemId = null;

// 编辑商品
function editGoods(id) {
    // 根据id获取商品详细信息
    fetch(`http://localhost:8080/good/getOne?id=${id}`)
        .then(response => response.json())
        .then(data => {
            if (data.code === 1) {
                const item = data.data;
                currentEditItemId = id;
                document.getElementById("editName").value = item.name;
                document.getElementById("editPrice").value = item.price;
                document.getElementById("editCount").value = item.count;
                document.getElementById("editDescription").value = item.description;
                openEditForm();
            }
        });
}

// 打开编辑表单
function openEditForm() {
    document.getElementById("editForm").style.display = "block";
}

// 关闭编辑表单
function closeEditForm() {
    document.getElementById("editForm").style.display = "none";
}

// 更新商品信息
function updateGoods() {
    const editName = document.getElementById("editName").value;
    const editPrice = document.getElementById("editPrice").value;
    const editCount = document.getElementById("editCount").value;
    const editDescription = document.getElementById("editDescription").value;

    const requestBody = {
        id: currentEditItemId,
        name: editName,
        price: editPrice,
        count: editCount,
        description: editDescription,
    };

    fetch("http://localhost:8080/good/update", {
        method: "PUT",
        body: JSON.stringify(requestBody),
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => response.json())
        .then(data => {
            if (data.code === 1) {
                alert("更新成功");
                searchGoods();
                closeEditForm();
            } else {
                alert("更新失败:" + data.message)
                searchGoods();
            }
        });
}
