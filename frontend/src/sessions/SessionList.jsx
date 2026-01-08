import { useEffect, useState } from 'react';
import axios from '../api/axiosInstance';

export default function SessionList() {
  const [sessions, setSessions] = useState([]);

  useEffect(() => {
    axios.get('/sessions')
      .then(res => setSessions(res.data))
      .catch(console.error);
  }, []);

  return (
    <div>
      <h2>Sessions</h2>
      <ul>
        {sessions.map(s => (
          <li key={s.id}>
            {s.title} — {s.mentorName} — {s.dateTime || "No date"}
          </li>
        ))}
      </ul>
    </div>
  );
}
