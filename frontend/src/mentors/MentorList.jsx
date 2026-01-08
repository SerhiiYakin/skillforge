import { useEffect, useState } from 'react';
import axios from '../api/axiosInstance';

export default function MentorList() {
  const [mentors, setMentors] = useState([]);

  useEffect(() => {
    axios.get('/mentors')
      .then(res => setMentors(res.data))
      .catch(console.error);
  }, []);

  return (
    <div>
      <h2>Mentors</h2>
      <ul>
        {mentors.map(m => (
          <li key={m.id}>{m.firstname} {m.lastname} ({m.email})</li>
        ))}
      </ul>
    </div>
  );
}
