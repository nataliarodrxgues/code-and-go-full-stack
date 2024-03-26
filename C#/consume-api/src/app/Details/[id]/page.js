// Details component
import styles from './card.module.css';

export default async function Details({ params }) {
  console.log("esse é o id enviado: ", params.id);

  const card = await fetch(`http://localhost:5013/api/findagencia/${params.id}`).then((res) =>
  res.json(),
);
  return (
    <div className={styles.container}>
      <div className={styles.card}>
        <img src={card.agenciaURL} alt={card.Nome} />
        <div className={styles.card_title}>
          <p>{card.Nome}</p>
        </div>
      </div>
    </div>
  );
}

