package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReleasePileBunker extends AttackSkill {
    public ReleasePileBunker() {
        this.setName("릴리즈 파일 벙커");
        this.setAttackCount(8L);
        this.setDamage(1160.0);
        this.setDelay(150L);
        this.setRelatedSkill(new ReleasePileBunkerA());
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
