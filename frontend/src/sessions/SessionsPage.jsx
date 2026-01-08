import { useEffect, useState } from 'react';
import axios from '../api/axiosInstance';

export default function SessionsPage() {
  const [sessions, setSessions] = useState([]);

  useEffect(() => {
    axios.get('/sessions')
      .then(res => setSessions(res.data))
      .catch(err => console.error("Failed to fetch sessions", err));
  }, []);

  return (
    <div className="page-container">
      <h2>All Sessions</h2>
      <ul>
        {sessions.map(session => (
          <li key={session.id}>
            <h3>{session.title}</h3>
            <p>{session.description}</p>
            <p>
              {session.dateTime 
                ? new Date(session.dateTime).toLocaleString()
                : "Date not set"}
            </p>
            <p>Mentor: {session.mentorName}</p> {/* ✅ тільки mentorName */}
          </li>
        ))}
      </ul>
    </div>
  );
}
