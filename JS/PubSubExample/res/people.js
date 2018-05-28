var people = {
    people:0,
    elem:document.getElementById('people'),
    render: function(){
        var peopleElm = document.createElement("div");
        peopleElm.setAttribute("class","people")
        peopleElm.innerHTML = "Number of people"+this.people;
        this.elem.appendChild(peopleElm);
    },
    update: function(data){
        debugger;
        this.people = data.length;
        this.elem.querySelector('.people').innerHTML = "Number of people"+this.people;
    }
}
people.render();
events.subscribe('peopleChanged',people.update.bind(people));