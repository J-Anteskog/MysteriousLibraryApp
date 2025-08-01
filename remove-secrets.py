import sys

def filter_commit_blob_cb(blob):
    if blob.filename.decode('utf-8') in ['app.json', 'App.js']:
        content = blob.data.decode('utf-8')
        if 'AIzaSyDXR-ntdgK8H5RV7E_3hWZnNNj0c2Vp8dk' in content:
            content = content.replace('AIzaSyDXR-ntdgK8H5RV7E_3hWZnNNj0c2Vp8dk', '***REDACTED_API_KEY***')
            blob.data = content.encode('utf-8')
    return blob

if __name__ == '__main__':
    from git_filter_repo import RepoFilter
    RepoFilter().run()