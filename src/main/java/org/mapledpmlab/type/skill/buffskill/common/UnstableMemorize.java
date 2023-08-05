package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UnstableMemorize extends BuffSkill {
    public UnstableMemorize() {
        this.setName("언스테이블 메모라이즈");
        this.setDelay(870L);
        this.setRelatedSkill(new Infinity(0L));
    }
}
