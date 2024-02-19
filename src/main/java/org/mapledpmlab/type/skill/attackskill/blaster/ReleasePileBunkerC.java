package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReleasePileBunkerC extends AttackSkill {
    public ReleasePileBunkerC() {
        this.setName("릴리즈 파일 벙커(충격파C)");
        this.setAttackCount(6L);
        this.setDamage(540.0 + 158);
        this.setRelatedSkill(new ReleasePileBunkerD());
        this.setAddDamage(15L);         // 릴리즈 파일 벙커-쇼크 웨이브 리인포스
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
