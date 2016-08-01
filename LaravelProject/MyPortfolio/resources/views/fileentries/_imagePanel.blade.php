<script>
    function addText(src){
        var text = document.forms.createForm.content.value;
        text += "<img class='article-image' src='" + src + "'>";
        document.forms.createForm.content.value = text;
    }
</script>

<div class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--4dp">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">Images</h2>
    </div>

    <ul class="mdl-list">
            <li class="mdl-list__item">
                <span class="mdl-list__item-primary-content">
                    {!! Form::open(['url'=>'fileentry/add', 'files' => true]) !!}
                    {!! Form::file('filefield') !!}

                    {!! Form::submit('upload', ['class' => 'mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent']) !!}
                    {!! Form::close() !!}
                </span>
            </li>
        @foreach($images as $image)
            <li class="mdl-list__item">
                <span class="mdl-list__item-primary-content">
                    <img src="{{ route('getentry', str_replace('.','_',$image->filename)) }}" class="image-list-icon" alt="">
                    <button onclick="addText('{{ route('getentry', str_replace('.','_',$image->filename)) }}')" class="mdl-button mdl-js-button mdl-button--primary">
                        add
                    </button>
                </span>
            </li>
            <hr>
        @endforeach
    </ul>
</div>