@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">{{ $post -> title }}</h2>
        </div>
        <div class="mdl-card__media">
            <img class="article-image" src="../images/portfolio-example-01.jpg" border="0" alt="">
        </div>
        <div class="mdl-card__supporting-text">
            <strong>Category</strong>
            <span>{{ $post -> category_id }}</span>
        </div>

        <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Description</h3>
        <div class="mdl-cell mdl-cell--6-col mdl-card__supporting-text no-padding">
            <p>{{ $post -> description }}</p>
        </div>
        <div class="mdl-cell mdl-cell--6-col">
            <img class="article-image" src="../images/portfolio-example-02.jpg" border="0" alt="">
        </div>

        <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Initial Ideas</h3>
        <div class="mdl-cell mdl-cell--6-col">
            <img class="article-image" src="../images/portfolio-example-03.jpg" border="0" alt="">
        </div>
        <div class="mdl-cell mdl-cell--6-col mdl-card__supporting-text no-padding ">
            <p>
                Excepteur reprehenderit sint exercitation ipsum consequat qui sit id velit elit. Velit anim eiusmod labore sit amet. Voluptate voluptate irure occaecat deserunt incididunt esse in. Sunt velit aliquip sunt elit ex nulla reprehenderit qui ut eiusmod ipsum do. Duis veniam reprehenderit laborum occaecat id proident nulla veniam. Duis enim deserunt voluptate aute veniam sint pariatur exercitation. Irure mollit est sit labore est deserunt pariatur duis aute laboris cupidatat. Consectetur consequat esse est sit veniam adipisicing ipsum enim irure.
            </p>
        </div>
    </div>
    <h1>ID : {{ $post -> id }}</h1>
    <h1>Title : {{ $post -> title }}</h1>
    <hr>
    <p>Slug : {{ $post -> slug }}</p>
    <p>Description : {{ $post -> description }}</p>
    <p>Summary : {{ $post -> summary }}</p>
    <p>Content : {!! $post -> content !!}</p>
    <p>Status : {{ $post -> status }}</p>
    <p>Comments : {{ $post -> comments }}</p>
    <p>Featured : {{ $post -> featured }}</p>
@stop