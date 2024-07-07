package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IfritSummon extends AttackSkill {
    public IfritSummon() {
        this.setName("이프리트(소환수)");
        this.setDamage(152.0);
        this.setAttackCount(3L);
        this.setInterval(3030L);
        this.setDotDuration(260000L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(-40L);        // 아케인 에임 소환수 미적용
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
