@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--8-col mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Create Blog</h2>
        </div>
        <div class="mdl-card__supporting-text">

            {!! Form::open(['url'=>'post']) !!}

                <div class="mdl-cell mdl-cell--12-col">
                    {!! Form::select('category_id', $categories, null, ['placeholder' => 'Pick category']) !!}
                    <p>or</p>
                    <a href="{{ url('category/create') }}"> Create </a>
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    {!! Form::text('title', null, ['class' => 'mdl-textfield__input']) !!}
                    {!! Form::label('title', 'Title:', ['class' => 'mdl-textfield__label']) !!}
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    {!! Form::text('slug', null, ['class' => 'mdl-textfield__input']) !!}
                    {!! Form::label('slug', 'Slug:', ['class' => 'mdl-textfield__label']) !!}
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    {!! Form::text('description', null, ['class' => 'mdl-textfield__input']) !!}
                    {!! Form::label('description', 'Description:', ['class' => 'mdl-textfield__label']) !!}
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    {!! Form::textarea('summary', null, ['class' => 'mdl-textfield__input', 'rows' => '8']) !!}
                    {!! Form::label('summary', 'Summary:', ['class' => 'mdl-textfield__label']) !!}
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    {!! Form::textarea('content', null, ['class' => 'mdl-textfield__input', 'rows' => '30']) !!}
                    {!! Form::label('content', 'Content:', ['class' => 'mdl-textfield__label']) !!}
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    {!! Form::text('status', null, ['class' => 'mdl-textfield__input', 'placeholder' => 'draft or publish']) !!}
                    {!! Form::label('status', 'Status:', ['class' => 'mdl-textfield__label']) !!}
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="comments_switch">
                        {!! Form::checkbox('comments', '1', true, ['class' => 'mdl-switch__input', 'id' => 'comments_switch']) !!}
                        <span class="mdl-switch__label">Comments</span>
                    </label>
                </div>

                <div class="mdl-cell mdl-cell--4-col">
                    <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="featured_switch">
                        {!! Form::checkbox('featured', '1', true, ['class' => 'mdl-switch__input', 'id' => 'featured_switch']) !!}
                        <span class="mdl-switch__label">Featured</span>
                    </label>
                </div>
                <p>
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                        Submit
                    </button>
                </p>

            {!! Form::close() !!}
        </div>
    </div>

    <div class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--4dp">
    <p>image</p>
    </div>
@stop