# Crochet Companion

A website meant to help you manage your crochet projects, complete with a built in stitch dictionary!

Currently a work in progress. If you're interested and want to learn more about this project, feel free to email me at samanthalstinchcomb@gmail.com


## API Reference

#### Get All Stitches

```http
  GET /api/crochet-stitches
```

| Parameter      | Type     | Description                |
| :------------- | :------- | :------------------------- |
| `name`         | `String` | To search by name          |
| `abbreviation` | `String` | To search by abbreviation  |


#### Get Crochet Stitch

```http
  GET /api/crochet-stitches/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `String` | **Required:** ID of crochet stitch |


#### Get All User Projects

```http
  GET /api/projects
```

| Parameter  | Type     | Description                       |
| :--------  | :------- | :-------------------------------- |
| `principal`| `Principal` | **Required:** Principal to identify user |


#### Get Project

```http
  GET /api/projects/${id}
```

| Parameter  | Type     | Description                       |
| :--------  | :------- | :-------------------------------- |
| `principal`| `Principal` | **Required:** Principal to identify user |
| `id`       | `string` | **Required:** ID of project |


#### Post Project

```http
  POST /api/projects/
```

| Parameter  | Type     | Description                       |
| :--------  | :------- | :-------------------------------- |
| `principal`| `Principal` | **Required:** Principal to identify user |
| `request`| `CreateProjectRequest` | **Required:** User generated details of project to be created |


#### Sign Up

```http
  POST /api/auth/signup
```

| Parameter  | Type     | Description                       |
| :--------  | :------- | :-------------------------------- |
| `signupRequest`| `SignUpRequest` | **Required:** User generated details for account creation |


#### Sign In

```http
  POST /api/auth/signin
```

| Parameter  | Type     | Description                       |
| :--------  | :------- | :-------------------------------- |
| `loginRequest`| `LoginRequest` | **Required:** User generated details for account confirmation |
