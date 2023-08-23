package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarksmanCrewNectar extends AttackSkill {
    public MarksmanCrewNectar() {
        this.setName("명사수 크루(언티어링 넥타)");
        this.setAttackCount(4L);
        this.setDamage(220.0);
        this.setInterval(1440L);
        this.addFinalDamage(1.16);      // 크루 커맨더십
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
