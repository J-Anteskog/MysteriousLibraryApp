import git_filter_repo as gfr

# Den gamla, exponerade nyckeln
old_key = b'AIzaSyDXR-ntdgK8H5RV7E_3hWZnNNj0c2Vp8dk'

# Den nya, dolda nyckeln
new_key = b'***REDACTED_API_KEY***'

# En funktion som körs för varje fil i varje commit
def replace_key_in_file(blob):
    # Kontrollera om filen är app.json eller App.js
    if blob.filename.decode('utf-8') in ['app.json', 'App.js']:
        # Ersätt den gamla nyckeln med den nya
        blob.data = blob.data.replace(old_key, new_key)
    return blob

# Kör filter-repo med vår funktion
if __name__ == '__main__':
    gfr.RepoFilter(blob_callback=replace_key_in_file).run()