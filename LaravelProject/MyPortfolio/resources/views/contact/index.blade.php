@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--12-col mdl-card mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Contact</h2>
        </div>
        <div class="mdl-card__media">
            <img src="../images/contact-image.jpg" alt="Contact Me" border="0" class="article-image">
        </div>

        <div class="mdl-grid portfolio-copy">
            <div class="mdl-cell mdl-cell--8-col mdl-card__supporting-text no-padding">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium ad architecto autem consectetur cupiditate dignissimos dolor, dolore, eius eum explicabo in, ipsum iure minus nemo quae quibusdam quo reprehenderit voluptatibus?
            </div>
        </div>
    </div>

    @foreach($contacts as $contact)
        <div class="mdl-cell mdl-cell--3-col mdl-cell--2-col-phone mdl-cell--2-col-tablet mdl-card mdl-shadow--4dp portfolio-card">
            <div class="mdl-card__media">
                <img class="article-image" src="{{ $contact->image }}" border="0" alt="">
            </div>
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">{{ $contact->name }}</h2>
            </div>
            <div class="mdl-card__supporting-text">
                {{ $contact->description }}
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="{{ $contact->url }}">
                    Visit
                </a>
            </div>
        </div>
    @endforeach
@stop