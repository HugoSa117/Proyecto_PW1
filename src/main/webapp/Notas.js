//Definimos variables
const url= ''
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalNotas = new bootstrap.Modal(document.getElementById('modalNota'))
const formNota = document.querySelector('form')

const titulo = document.getElementById('titulo')
const etiqueta = document.getElementById('etiqueta')
const contenido = document.getElementById('contenido')

let opcion = ' '

btnCrear.addEventListener('click', ()=>{
    titulo.value = ''
    etiqueta.value = ''
    contenido.value = ''
    modalNotas.show()
    opcion = 'crear'
})

//Procedimiento para mostrar los registros de cada nota

fetch(url)
    .then(response => response.json)
    .then(data => mostrar(data))
    .catch( error => console.log(error))

