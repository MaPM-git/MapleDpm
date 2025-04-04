package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DualPistolCrew extends AttackSkill {
    public DualPistolCrew() {
        this.setName("쌍권총 크루");
        this.setAttackCount(6L);
        this.setDamage(965.0);
        this.setDotDuration(120000L);
        this.setInterval(3030L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new MarksmanCrew());
    }
}
