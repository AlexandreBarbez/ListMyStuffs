var url = "https://listmystuffs.alexandrebarbez.com/";
//dev =  http://localhost:8080/

const addStuff = new Vue({
  el: '#addStuff',
  data: {
    errors: [],
    item: {
      nom:'',
      description:'',
      quantite:'',
      prix:''
    },
  },
  methods: {

    addItem: function()
    {
      var itemToAdd = {nom: this.item.nom,
                        description: this.item.description,
                        quantite: this.item.quantite,
                        prix: this.item.prix};

      this.errors = checkItem(itemToAdd);

      if(!this.errors.length){
        fetch(url+'stuffs', {
        method: 'post',
        headers: {
          'Accept': 'application/json, text/plain, */*',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({nom: this.item.nom,
                              description: this.item.description,
                              quantite: this.item.quantite,
                              prix: this.item.prix})
        }).then(res=>res.json())
        .then(stuffs.items.push(itemToAdd))
        .then(reset(this.item));
      }
    }
  }
});

const stuffs = new Vue({
  el: '#stuffs',
  data: {
    items: []
  },
  created () {
    fetch(url+'stuffs')
      .then(response => response.json())
      .then(json => {this.items = json})
  },
  methods: {
    deleteItem: function(item){
      console.log(item.id);
      fetch(url+'stuffs/'+item.id, {
        method: 'delete'
      })
    this.items.splice(this.items.indexOf(item), 1);
    }
  }
})

function checkItem(item) {
  let errors = [];

  if (!item.nom) {
    errors.push('Name required.');
  }
  if (!item.description) {
    errors.push('description required.');
  }
  if (!item.quantite) {
    errors.push('quantite required.');
  }
  if (!item.prix) {
    errors.push('prix required.');
  }
  if(isNaN(item.quantite)) {
    errors.push('quantite is not a number');
  }
  if(isNaN(item.prix)) {
    errors.push('prix is not a number');
  }
  return errors
}

function reset(item) {

  // for all properties
  for (const prop of Object.getOwnPropertyNames(item)) {
    delete item[prop];
  }

}
