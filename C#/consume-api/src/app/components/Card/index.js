import Link from 'next/link';
import styles from './card.module.css';

export default async function Card() {
  // Fetch data from the API
  const response = await fetch('http://localhost:5013/api/findagencia').then(r => r.json());

  // Destructure the 'data' property from the response
  const { data } = response;

  console.log('Data from API:', data);

  return (
    <div className={styles.container}>
      {data?.map((card) => (
        <div key={card.id} className={styles.card}>
          <img src={card.agenciaURL} alt={card.title} />
          <div className={styles.card_title}>
            <p>{card.name}</p>
          </div>
          <div className={styles.button_container}>
            <Link
              className={styles.button_link}
              href={{
                pathname: `/Details/`,
                query: { id: card.id },
              }}
              as={`/Details/${card.id}`}
            >
              +
            </Link>
          </div>
        </div>
      ))}
    </div>
  );
}
